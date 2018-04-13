package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.fpdual.eadmin.eadmin.util.ModeloAbstracto;

public class DocumentoTest extends ModeloAbstracto<Documento> {

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ULTIMA_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;

	@Override
	public void before() {
		this.entityA1 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_ULTIMA_MODIFICACION,
				DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);
		this.entityA2 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_ULTIMA_MODIFICACION,
				DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);
		this.entityB = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_ULTIMA_MODIFICACION,
				DOCUMENTO_PUBLICO, EstadoDocumento.ELIMINADO);
	}

	@Override
	public void deberiaInvocarLosMetodosGetModelo() {
		assertEquals(EstadoDocumento.ACTIVO, this.entityA1.getEstado());

	}

}
