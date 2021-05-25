/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import javax.json.bind.annotation.JsonbCreator;

/**
 *
 * @author hantsy
 */
public record RecordPerson( String name, int age) {

	@JsonbCreator
	public RecordPerson{
		if(age <= 0) {
			throw new IllegalArgumentException(
                "The age of a person must be positive");
		}
	}
	public RecordPerson(String name){
		this(name, 20);
	}
}
