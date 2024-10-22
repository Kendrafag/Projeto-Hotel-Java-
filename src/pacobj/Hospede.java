package pacobj;
import java.time.LocalDate;

public class Hospede {
	private String nomeHhospede;
	private LocalDate dataHentrada;
	private Integer quartosHreservados;
	private Integer tipoHreservado;
	
	public String getNomeHhospede() {
		return nomeHhospede;
	}
	public void setNomeHhospede(String nomeHhospede) {
		this.nomeHhospede = nomeHhospede;
	}
	public LocalDate getDataHentrada() {
		return dataHentrada;
	}
	public void setDataHentrada(LocalDate dataHentrada) {
		this.dataHentrada = LocalDate.now();
	}
	public Integer getQuartosHreservados() {
		return quartosHreservados;
	}
	public void setQuartosHreservados(Integer quartosHreservados) {
		this.quartosHreservados = quartosHreservados;
	}
	public Integer getTipoHreservado() {
		return tipoHreservado;
	}
	public void setTipoHreservado(Integer tipoHreservado) {
		this.tipoHreservado = tipoHreservado;
	}
	public Hospede(String nomeHhospede, LocalDate dataHentrada, Integer quartosHreservados, Integer tipoHreservado) {
		super();
		this.nomeHhospede = nomeHhospede;
		this.dataHentrada = dataHentrada;
		this.quartosHreservados = quartosHreservados;
		this.tipoHreservado = tipoHreservado;
		
		

	}
	public Hospede() {

}
}
