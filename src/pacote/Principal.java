package pacote;
import pacobj.Quarto;
import pacobj.Reserva;
import pacobj.Hospede;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static Scanner scanner = new Scanner(System.in);
	static List<Quarto> listarquartos = new ArrayList<Quarto>();
	static List<Reserva> listareservas = new ArrayList<Reserva>();
	static List<Hospede> listarhospedes = new ArrayList<Hospede>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuprincipal();
		
	}
	public static void menuprincipal() {
		System.out.println("Bem-vindo ao sistema de gerenciamento de hotéis!");
		System.out.println("Digite a opção que deseja:");
		System.out.println("1- Cadastrar quarto"+"2- Cadastrar reserva"+"3- Gerenciar check-in/check-out");
		System.out.println("4- Acompanhamento de ocupação de quartos"+"5- Histórico de reservas"+"6- Sair");
		int op = scanner.nextInt();
		if(op==1) {
			cadastrarQuarto();
		}
		else if(op==2) {
			cadastrarReserva();
		}
		else if(op==3) {
			gerenciarCheck();
		}
		else if(op==4) {
			acompanhamentoQuarto();
		}
		else if(op==5) {
			históricoReserva();
		}
		else if(op==6) {
			System.out.println("Sistema encerrado com sucesso!");
			System.exit(0);
		}
		else {
			System.out.println("ERRO- Escolha entre 1-6");
		}
		
		
	}
	public static void cadastrarQuarto() {
		Quarto quarto = new Quarto();
		
		
		System.out.println("Qual o número do quarto?");
		quarto.setNumQuarto(scanner.nextInt());
		scanner.nextLine();
		
		System.out.println("Qual o tipo de quarto? 1=Casal, 2=Solteiro,3-Suite");
		int escolha = scanner.nextInt();
		if(escolha==1) {
			quarto.setTipoQuarto("Casal");
		}
		else if(escolha==2) {
			quarto.setTipoQuarto("Solteiro");
		}
		else if(escolha==3) {
			quarto.setTipoQuarto("Suite");
		}
		else
		{
		System.out.println("Erro - Digite entre 1 a 3");
		}
		
		System.out.println("Digite o preço da diária do quarto:");
		quarto.setPrecoDiario(scanner.nextDouble());
		
		quarto.setDisponibilidade(true);
		listarquartos.add(quarto);
		
		System.out.println("Quarto cadastrado com sucesso!");
		
		menuprincipal();
	}
	public static void cadastrarReserva() {
		Reserva reserva = new Reserva();
	    Hospede hospede = new Hospede();
	    System.out.println("Qual o nome do hóspede?");
	    String nomeHospede = scanner.next();
	    hospede.setNomeHhospede(nomeHospede);
	    scanner.nextLine();
	    
	    listarhospedes.add(hospede);
	    
	    reserva.setDataEntrada(); 
	    System.out.println("A data de entrada é: " + reserva.getDataEntrada());
	    
	    System.out.println("Digite a data de saída (yyyy-MM-dd):");
	    String dataSaidaStr = scanner.next();
	    LocalDate dataSaida = LocalDate.parse(dataSaidaStr);
	    reserva.setDataSaída(dataSaida);
	    scanner.nextLine();
	    
	    boolean continuarAdicionandoQuartos = true;
	    while (continuarAdicionandoQuartos) {
	        System.out.println("Número do quarto que deseja reservar (ou 0 para finalizar):");
	        int numeroQuarto = scanner.nextInt();
	        scanner.nextLine(); 
	        if (numeroQuarto == 0) {
	            continuarAdicionandoQuartos = false; 
	        } 
	        else {
	            Quarto quarto = encontrarQuartoPorNumero(numeroQuarto);
	            if (quarto != null && quarto.getDisponibilidade()) {
	                reserva.adicionarQuarto(quarto);
	                quarto.setDisponibilidade(false);
	                System.out.println("Quarto " + numeroQuarto + " adicionado à reserva.");
	            } else {
	                System.out.println("Quarto não encontrado ou indisponível.");
	            }
	        }
	    }
	    if (reserva.getQuartosReservados().isEmpty()) { 
	        System.out.println("Nenhum quarto foi adicionado à reserva. Reserva cancelada.");
	        return; 
	    }
	   
	    if (!reserva.getQuartosReservados().isEmpty()) {
	        reserva.setTipoReservado(reserva.getQuartosReservados().get(0).getTipoQuarto());
	    }
	    listareservas.add(reserva);
	    System.out.println("Reserva concluída com sucesso!");
	   
	    for (Reserva listarReservas : listareservas) {
	    	System.out.println(listarReservas);
	    	
	    }
	   
	    menuprincipal();
	}
	public static void gerenciarCheck() {
		 System.out.println("Escolha uma opção: 1- Check-in ou 2- Check-out");
		    int opcao = scanner.nextInt();
		    scanner.nextLine(); 

		    if (opcao == 1) {
		        realizarCheckin();
		    } else if (opcao == 2) {
		        realizarCheckout();
		    } else {
		        System.out.println("Opção inválida. Retornando ao menu principal.");
		    }

		    menuprincipal();
		}

		public static void realizarCheckin() {
		    System.out.println("Digite o nome do hóspede para realizar o check-in:");
		    String nomeHospede = scanner.nextLine();

		    Reserva reserva = encontrarReservaPorHospede(nomeHospede);
		    if (reserva != null) {
		        System.out.println("Realizando check-in para " + nomeHospede);
		        reserva.setCheckIn(true);  
		        System.out.println("Check-in realizado com sucesso.");
		    } else {
		        System.out.println("Reserva não encontrada para o hóspede " + nomeHospede);
		    }
		}

		public static void realizarCheckout() {
		    System.out.println("Digite o nome do hóspede para realizar o check-out:");
		    String nomeHospede = scanner.nextLine();

		    Reserva reserva = encontrarReservaPorHospede(nomeHospede);
		    if (reserva != null) {
		        System.out.println("Realizando check-out para " + nomeHospede);
		        liberarQuartos(reserva);
		        listareservas.remove(reserva);  
		        System.out.println("Check-out realizado com sucesso. Quarto(s) liberado(s).");
		    } else {
		        System.out.println("Reserva não encontrada para o hóspede " + nomeHospede);
		    }
		}

		
		public static Reserva encontrarReservaPorHospede(String nomeHospede) {
		    for (Reserva reserva : listareservas) {
		        if (reserva.getNomeHospede().equals(nomeHospede)) {
		            return reserva;
		        }
		    }
		    return null;
		}

		
		public static void liberarQuartos(Reserva reserva) {
		    for (Quarto quarto : reserva.getQuartosReservados()) {
		        quarto.setDisponibilidade(true); 
		    }
		}
		
	
	public static void acompanhamentoQuarto() {
		System.out.println("Acompanhamento de ocupação de quartos:");

	    if (listareservas.isEmpty()) {
	        System.out.println("Não há quartos ocupados no momento.");
	        return;
	    }

	    
	    for (Reserva reserva : listareservas) {
	        if (reserva.isCheckIn()) {  
	            System.out.println("Hóspede: " + reserva.getNomeHospede());
	            System.out.println("Data de entrada: " + reserva.getDataEntrada());
	            System.out.println("Data de saída: " + reserva.getDataSaída());
	            System.out.println("Quartos ocupados:");

	            for (Quarto quarto : reserva.getQuartosReservados()) {
	                System.out.println("Número do quarto: " + quarto.getNumQuarto() + 
	                                   " | Tipo de quarto: " + quarto.getTipoQuarto());
	            }

	            System.out.println("---------");
	        }
	    }

	    menuprincipal();
	}
	public static void históricoReserva() {
		if (listareservas.isEmpty()) {
	        System.out.println("Não há reservas cadastradas.");
	        return;
	    }


	    System.out.println("Histórico de Reservas por Hóspede:");
	    System.out.printf("%-20s %-20s %-20s %-20s%n", "Nome do Hóspede", "Data de Reserva", "Nº de Quartos", "Tipo de Quarto");
	    
	   
	    for (Reserva reserva : listareservas) {
	        String nomeHospede = reserva.getNomeHospede();
	        LocalDate dataReserva = reserva.getDataEntrada();  
	        int numeroQuartos = reserva.getQuartosReservados().size();  
	        
	      
	        String tipoQuarto = reserva.getTipoReservado(); 
	        System.out.printf("%-20s %-20s %-20d %-20s%n", nomeHospede, dataReserva, numeroQuartos, tipoQuarto);
	    }

	   
	    menuprincipal();
	}
		
	
	
	
	public static Quarto encontrarQuartoPorNumero(int numeroQuarto) {
	    for (Quarto q : listarquartos) {
	        if (q.getNumQuarto() == numeroQuarto) {
	            return q;
	        }
	    }
	    return null;
	}
	
	
}
