package com.nttdata.circuitbreaker.clase;

public class Estado {
	private String [] paquetes;
	private long limitError;
	private int intentoActual;
	private int intentosMax;
	
	public Estado(String [] paquetes, long limitError, int intentoActual, int intentosMax) {
		this.paquetes = new String[paquetes.length];
		setPaquetes(paquetes);
		this.limitError = limitError;
		this.intentoActual = intentoActual;
		this.intentosMax = intentosMax;
	}
	
	public EstadoEnum getEstado() {
		EstadoEnum estado = EstadoEnum.CLOSED;
		long maxError = paquetes.length*limitError/100;
		int nOK=0;
		int nKO=0;
		
		if(intentoActual<paquetes.length) {
			estado = EstadoEnum.HALF_OPEN;
		}else {
			for(int i=0; i<paquetes.length; i++) {
				if(paquetes[i]=="ok") {
					nOK++;
				}else if(paquetes[i]=="ko"){
					nKO++;
				}
			}
			
			if(nKO>=maxError) {
				estado = EstadoEnum.OPEN;
			}else if(nKO<maxError) {
				estado = EstadoEnum.CLOSED;
			}
		}
		
		
		return estado;
		
	}
	
	private void setPaquetes(String [] paquetes) {
		for(int i=0; i<paquetes.length; i++) {
			
			this.paquetes[i]=paquetes[i];
		}
		
	}
	
	
}
