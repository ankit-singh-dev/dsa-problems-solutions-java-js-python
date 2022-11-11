package com.inn.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor
public class SinglyNode {
	@NonNull
	private String data;
	private SinglyNode next;
	
	
}
