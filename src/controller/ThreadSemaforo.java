package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadSemaforo extends Thread{
	private int idCarro;
	private static int passar;
	private Semaphore semaforo;
	private String inicio[] = {"Norte e atravessou para Sul","Sul e atravessou para Norte",
			"Leste e atravessou para Oeste","Oeste e atravessou para Leste"};

	public ThreadSemaforo(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		// --------P(acquire)-----------
		try {
			semaforo.acquire();
			Cruzamento();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} finally {
			// --------V (release)----------
			semaforo.release();
			Proximo();
		}
	}
	
	public void Cruzamento() {
		Random r = new Random();
		try {
			sleep(450);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(passar) {
		case 0: System.out.println("O carro: "+idCarro+" que estava na via "+inicio[0]);
		break;
		case 1: System.out.println("O carro: "+idCarro+" que estava na via "+inicio[1]);
		break;
		case 2: System.out.println("O carro: "+idCarro+" que estava na via "+inicio[2]);
		break;
		case 3: System.out.println("O carro: "+idCarro+" que estava na via "+inicio[3]);
		break;
		}
	}
	
	public void Proximo() {
		System.out.println("O proximo já está liberado");
		passar++;
	}
	
	
}
