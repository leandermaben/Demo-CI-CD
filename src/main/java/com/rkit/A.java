package com.rkit;

public class A {
	private B b;
	private C c ;
	A(B b){
		System.out.println("A created !!");
		this.b = b;
	}
	A (B b, C c ){
		System.out.println("A created with  B and C !!");
		this.b = b;
		this.c = c;
	}

}
