# Crypting
Uma aplicação usada para o desafio de descriptografia usando cifragens de Cesar e DES.

## Regras e Limitações
Esta aplicação está sujeita as seguintes regras:
- a criptografia é feita apenas com as cifras de Cesar e DES;
- a aplicação da ciptografia consiste em uma cifragem recursiva de profundidade 2;
- existe a repetição de apenas uma das cifras;
- o alfabeto usado na cifragem de Cesar é o inglês;
- o tamanho da chave secreta de Cesar varia de 18 a 25 (base 10);
- o tamanho da chave secreta do DES varia de 0x000000 a 0xffffff;


## Uso
Clone esta aplicação, depois execute o seu empacotamento via Maven:

```
> git clone https://github.com/ag-ifpb/crypting.git
  Cloning into 'crypting'... 
  remote: Counting objects: 47, done.
  remote: Compressing objects: 100% (37/37), done.
  remote: Total 47 (delta 5), reused 45 (delta 5), pack-reused 0
  Unpacking objects: 100% (47/47), done.
  Checking connectivity... done.
```
```
> cd crypting
> mvn package
  [INFO] Scanning for projects...
  [INFO]                                                                         
  [INFO] ------------------------------------------------------------------------
  [INFO] Building IFPB EncryptDecrypt Toy 0.0.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO] 
  ...
```

Após isto basta digitar os comandos seguindo a seguinte sintaxw:
```
> java -jar target/app.jar <options> <text|encripted_text>
```

## Opções
```
usage: java -jar target/app.jar <options> text

 -dec          executa uma decriptografia (inválido se usar -enc)
 -enc          executa uma criptografia (default)
 -h            estas informações
 -ks <arg>     lista de chaves de 6 digitos separadas por vírgula e sem
               espaço. Exemplo: 999999,111111,000000
 -search       faz uma pesquisa usando chaves randomicas (não
               implementado)
 -type <arg>   digite uma das opções: ccd, cdc, dcc, ddc, dcd, cdd
```


## Exemplo (criptografando)

Para criptografar o texto 'Maria Amélia' no modo ddc (DES-DES-Cesar) com chaves '123456,654321,19', faça:

```
> java -jar target/app.jar -type ddc -ks 123456,654321,19 'Maria Amélia'
```
O resultado:
```
> java -jar target/app.jar -type ddc -ks 123456,654321,19 'Maria Amélia'
  Encriptando: Maria Amélia
  Estratégia selecionada: DDC
      --------------------------
      tipo#0: D
      chave#0: 123456
      result#0: XqjIKmzoLxoCgLj+w6ePcw==
      -------------------------
      tipo#1: D
      chave#1: 654321
      result#1: tE+IeddqxZ71p6pI6j/+Z/rCJZnx+47om45VznUbsBs=
      -------------------------
      tipo#2: C
      chave#2: 19
      result#2: mX+BxwwjqS71i6iB6c/+S/kVCSgq+47hf45OsgNulUl=
      -------------------------
  Texto criptografado: mX+BxwwjqS71i6iB6c/+S/kVCSgq+47hf45OsgNulUl=
```

## Exemplo (decriptografando)

//TODO

## Referências

//TODO

