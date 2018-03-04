package com.marvinjason.huffmancoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marvin Jason Sy
 */
public class HuffmanCoding
{
    private final LinkedHashMap map;
    private final List<Node> nodes;
    private final Map<Character, String> dictionary;
    private final String string;
    private StringBuilder path;
    private int compressedSize;
    private int uncompressedSize;
    private String compressedString;

    /**
     * Algorithm that compresses text using Huffman coding.
     * 
     * @param text text to compress
     */
    public HuffmanCoding(String text)
    {
        map = new LinkedHashMap();
        nodes = new ArrayList();
        dictionary = new HashMap();
        string = text;

        for (char c: text.toCharArray())
        {
            if (map.containsKey(c))
            {
                map.put(c, ((int) map.get(c)) + 1);
            }
            else
            {
                map.put(c, 1);
            }
        }

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry entry = (Map.Entry) iterator.next();
            nodes.add(new Node((int) entry.getValue(), (char) entry.getKey()));
        }

        buildTree();
    }

    private void buildTree()
    {
        while (nodes.size() != 1)
        {
            sort();

            Node node = new Node(nodes.get(0).getData() + nodes.get(1).getData());
            node.setWidth(nodes.get(0).getWidth() + nodes.get(1).getWidth() + 60);
            node.setHeight(Math.max(nodes.get(0).getHeight(), nodes.get(1).getHeight()) + 80);
            node.setMiddle(nodes.get(0).getWidth());
            node.setLeftChild(nodes.get(0));
            node.setRightChild(nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
        }
    }

    private void sort()
    {
        Collections.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node x, Node y)
            {
                return Integer.valueOf(x.getData()).compareTo(Integer.valueOf(y.getData()));
            }
        });
    }

    /**
     * Compresses the string passed in the constructor
     */
    public void compress()
    {
        StringBuilder str = new StringBuilder();

        for (char c: string.toCharArray())
        {
            path = new StringBuilder();
            compress(c, nodes.get(0));
            str.append(path);
            dictionary.put(c, path.toString());
        }

        uncompressedSize = string.length() * 8;
        compressedSize = str.length();
        compressedString = str.toString();
    }

    private boolean compress(char c, Node node)
    {
        if (node.getCharacter() == c)
        {
            return true;
        }

        if (node.getLeftChild() != null)
        {
            path.append('0');

            if (compress(c, node.getLeftChild()))
            {
                return true;
            }

            path.deleteCharAt(path.length() - 1);
        }

        if (node.getRightChild() != null)
        {
            path.append('1');

            if (compress(c, node.getRightChild()))
            {
                return true;
            }

            path.deleteCharAt(path.length() - 1);
        }

        return false;
    }

    /**
     * Returns the size of the text after compression
     * 
     * @return the compressed text size
     */
    public int getCompressedSize()
    {
        return compressedSize;
    }

    /**
     * Returns the size of the text before compression
     * 
     * @return the uncompressed text size
     */
    public int getUncompressedSize()
    {
        return uncompressedSize;
    }

    /**
     * Returns the text after compression
     * 
     * @return the compressed text
     */
    public String getCompressedString()
    {
        return compressedString;
    }

    /**
     * Returns a map that contains the binary representation
     * of each unique character in the text
     * 
     * @return the map containing binary representations
     */
    public Map<Character, String> getDictionary()
    {
        return dictionary;
    }

    /**
     * Returns the root node of the Huffman tree
     * 
     * @return the root node
     */
    public Node getRoot() { return nodes.get(0); }
}