package com.greatlearning.floorassemblyconfigurator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FloorAssemblyConfigurator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the total number of Floors in the Building: ");
		int maxFloor = scanner.nextInt();

		LinkedList<Integer> floorSizes = new LinkedList<Integer>();
		for (int i = 0; i < maxFloor; i++) {
			System.out.print("Enter the floor size available on Day " + (i + 1) + ": ");
			floorSizes.add(scanner.nextInt());
		}

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < floorSizes.size(); i++) {
			System.out.println();
			System.out.print("Day " + (i + 1) + ": ");

			priorityQueue.add(floorSizes.get(i));

			while (!priorityQueue.isEmpty() && priorityQueue.peek() == maxFloor) {
				System.out.print(priorityQueue.poll() + " ");
				maxFloor--;
			}
		}
		scanner.close();
	}
}
