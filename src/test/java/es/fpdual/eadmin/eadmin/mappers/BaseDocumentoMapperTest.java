package es.fpdual.eadmin.eadmin.mappers;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public abstract class BaseDocumentoMapperTest {

	private Documento documento;

	@Autowired
	private DocumentoMapper mapper;

	@Before
	public void inicializarVariables() {
		documento = new Documento(1, "Documento1", new Date(), new Date(), true, EstadoDocumento.ACTIVO);
	}

	@Test
	public void deberiaInsertarUnDocumento() {
		final int resultado = this.mapper.insertarDocumento(documento);

		assertEquals(1, resultado);
	}

}
