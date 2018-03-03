package com.marvinjason.huffmancoding;

/**
 *
 * @author Marvin Jason Sy
 */
public class Node
{
    private final int data;
    private Node leftChild;
    private Node rightChild;
    private char character;
    private int width;
    private int height;
    private int middle;

    Node(int data)
    {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.width = 60;
        this.height = 80;
        this.middle = 30;
    }

    Node(int data, char character)
    {
        this.data = data;
        this.character = character;
        this.leftChild = null;
        this.rightChild = null;
        this.width = 60;
        this.height = 80;
        this.middle = 30;
    }

    public int getData()
    {
        return this.data;
    }

    public Node getLeftChild()
    {
        return this.leftChild;
    }

    public Node getRightChild()
    {
        return this.rightChild;
    }

    public char getCharacter()
    {
        return this.character;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getMiddle()
    {
        return this.middle;
    }

    public void setLeftChild(Node node)
    {
        this.leftChild = node;
    }

    public void setRightChild(Node node)
    {
        this.rightChild = node;
    }

    public void setWidth(int width) { this.width = width; }

    public void setHeight(int height) { this.height = height; }

    public void setMiddle(int middle) { this.middle = middle; }
}