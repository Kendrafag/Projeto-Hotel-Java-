package pacobj;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Reserva {
	private String nomeHospede;
	private LocalDate dataEntrada;
	private LocalDate dataSaída;
	private List<Quarto> quartosReservados; 
	private String tipoReservado;
	private Boolean checkIn;
	
	
	public boolean isCheckIn() {
        return checkIn;
    }

  
    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }
	
	
	public Reserva() {
       quartosReservados = new ArrayList<>(); }
	
	public void adicionarQuarto(Quarto quarto) {
	       this.quartosReservados.add(quarto);
	    }
	
	
	public String getNomeHospede() {
		return nomeHospede;
	}
	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada() {
		this.dataEntrada = LocalDate.now();
	}
	public LocalDate getDataSaída() {
		return dataSaída;
	}
	
	public void setDataSaída(LocalDate dataSaída) {
		this.dataSaída = dataSaída;
	}
	public String getTipoReservado() {
		return tipoReservado;
	}
	public void setTipoReservado(String tipoReservado) {
		this.tipoReservado = tipoReservado;
	}
	
	public List<Quarto> getQuartosReservados() {
		return quartosReservados;
	}
	public void setQuartosReservados(List<Quarto> quartosReservados) {
		this.quartosReservados = quartosReservados;
	}
	
	
	@Override
	public String toString() {
		return "Reserva [nomeHospede=" + nomeHospede + ", dataEntrada=" + dataEntrada + ", dataSaída=" + dataSaída
				+ ", quartosReservados=" + quartosReservados + ", tipoReservado=" + tipoReservado + "]";
	}
	
	
	
	
}

