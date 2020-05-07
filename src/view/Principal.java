package view;

import java.util.concurrent.Semaphore;
import controller.ThreadSemaforo;

public class Principal {
	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idCarro = 1; idCarro <= 4; idCarro++) {
			Thread tsemaforo = new ThreadSemaforo(idCarro, semaforo);
			tsemaforo.start();
		}
	}
}
