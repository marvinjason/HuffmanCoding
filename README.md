# HuffmanCoding
Compresses your text using [Huffman coding](https://en.wikipedia.org/wiki/Huffman_coding). See the library in action in this [Android implementation](https://github.com/marvinjason/HuffmanCodingAndroid).

## Usage
Include the [library](https://github.com/marvinjason/HuffmanCoding/raw/master/dist/HuffmanCoding.jar) in your project
```java
import com.marvinjason.huffmancoding.HuffmanCoding;
```

Instantiate an object
```java
HuffmanCoding huffman = new HuffmanCoding("This text should be compressed.");
```

Compress the text and use the accessors
```java
huffman.compress();

System.out.println("Size before compression: " + huffman.getUncompressedSize());
System.out.println("Size after compression: " + huffman.getCompressedSize());

System.out.println("Compressed string: " + huffman.getCompressedString());
```

You can access the Huffman tree using the root node
```java
huffman.getRoot();
```

or get a character to binary representation map
```java
huffman.getDictionary();
```
