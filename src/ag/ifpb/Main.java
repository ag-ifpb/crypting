package ag.ifpb;

import java.math.BigInteger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import ag.ifpb.service.EncriptionType;
import ag.ifpb.service.Searcher;
import ag.ifpb.service.Strategy;
import ag.ifpb.service.StrategyFactory;
import ag.ifpb.service.impl.DecryptionException;
import ag.ifpb.service.impl.EncryptionException;
import ag.ifpb.service.impl.SearcherImpl;
import ag.ifpb.service.impl.StrategyFactoryImpl;

public class Main {
	
	private static int[] extractKeys(String ks){
		String[] keys = ks.split(",");
		//check if array
		if (keys == null || keys.length != 3) 
			throw new IllegalArgumentException("As chaves são obrigatórias");
		//check if hex-string
		for (String k : keys) {
			if (!k.matches("[0-9a-f]{6}|[0-9]{2}"))
				throw new IllegalArgumentException("Chave inválida. Uma chave é representada por um hexadecimal de 6 digitos ou um decimal de 2 dígitos, no máximo");
		}
		//convert hex to int
		int ix = 0;
		int[] kis = new int[3];
		for (String k : keys) {
			if(k.matches("[0-2][0-9]")){
				kis[ix++] = Integer.parseInt(k);
			} else {
				BigInteger bigInteger = new BigInteger(k, 16);
				kis[ix++] = bigInteger.intValue();
			}
		}
		return kis;
	}
	
	private static String extractText(String args0){
		String text = args0;
		if (text.isEmpty()){
			throw new IllegalArgumentException("Texto inválido. Digite o texto a ser criptografado ou correspondente a uma cifra");
		}
		return text;
	}
		
	private static String extractType(String type) {
		if (!type.matches("^(?!ccc)(?!ddd)[cd]{3}$"))
			throw new IllegalArgumentException("Tipo de estratégia inválida. Digite um tipo de estratégia válida");
		return type;
	}
		
	private static void execEncryptation(String type, int[] ks, String text) {
		System.out.println("Encriptando: " + text);
		//
		StrategyFactory encrypterFactory = new StrategyFactoryImpl();
		Strategy strategy = encrypterFactory.strategy(EncriptionType.convert(type));
		//
		try {
			System.out.println("Texto criptografado: " + strategy.encrypt(ks, text));
		} catch (EncryptionException e) {
			System.out.println("Falha na criptografia: " + e.getMessage());
		}
	}

	private static void execDecryptation(String type, int[] ks, String text) {
		System.out.println("Texto encriptado: " + text);
		//
		StrategyFactory encrypterFactory = new StrategyFactoryImpl();
		Strategy strategy = encrypterFactory.strategy(EncriptionType.convert(type));
		//
		try {
			System.out.println("Texto decriptografado: " + strategy.decrypt(ks, text));
		} catch (DecryptionException e) {
			System.out.println("Falha na decriptografia: " + e.getMessage());
		}
	}
	
	private static void execSearch(String text){
		System.out.println("Texto encriptado: " + text);
		//
		StrategyFactory strategyFactory = new StrategyFactoryImpl();
		//
		Searcher searcher = new SearcherImpl(strategyFactory);
		searcher.start(text);
	}

	public static void main(String[] args) throws ParseException {
		//
		Options options = new Options();
		options.addOption("h", false, "estas informações");
		options.addOption("enc", false, "executa uma criptografia (default)");
		options.addOption("dec", false, "executa uma decriptografia (inválido se usar -enc)");
		options.addOption("type", true, "digite uma das opções: ccd, cdc, dcc, ddc, dcd, cdd");
		options.addOption("ks", true, "lista de chaves de 6 digitos separadas por vírgula e sem espaço. "
				+ "Exemplo: 999999,111111,000000");
		options.addOption("search", false, "faz uma pesquisa usando chaves randômicas");
		//
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			//help
			if (cmd.hasOption("h")){
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("java -jar target/app.jar <options> text", options);
			}
			//search
			else if (cmd.hasOption("search")){
				//text - TODO reuse
				String text;
				if (!cmd.getArgList().isEmpty()){
					text = extractText( cmd.getArgList().get(0));
				} else {
					throw new IllegalArgumentException("Chamada com formato inválido. Faltando argumento 'text'");
				}
				//
				execSearch(text);
			}
			//enc or dec
			else {
				//keys
				int[] ks;
				if (cmd.hasOption("ks")){
					ks = extractKeys(cmd.getOptionValue("ks"));
				} else {
					throw new IllegalArgumentException("Chamada com formato inválido. Faltando opção '-ks'");
				}
				//type
				String type;
				if (cmd.hasOption("type")){
					type = extractType(cmd.getOptionValue("type"));
				} else {
					throw new IllegalArgumentException("Chamada com formato inválido. Faltando opção '-type'");
				}
				//text
				String text;
				if (!cmd.getArgList().isEmpty()){
					text = extractText( cmd.getArgList().get(0));
				} else {
					throw new IllegalArgumentException("Chamada com formato inválido. Faltando argumento 'text'");
				}
				//dec
				if (cmd.hasOption("dec") && !cmd.hasOption("enc")){
					execDecryptation(type, ks, text);
				} else {
					execEncryptation(type, ks, text);
				}
			}
	    }
	    catch(ParseException exp ) {
	        System.err.println( "Linha de comando incorreta. Razão: " + exp.getMessage() );
	    }
		catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	

	
	
}
