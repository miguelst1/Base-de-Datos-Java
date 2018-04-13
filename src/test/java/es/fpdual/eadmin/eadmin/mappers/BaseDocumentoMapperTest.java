package es.fpdual.eadmin.eadmin.mappers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.util.Utilidades;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	private Documento documento;

	@Autowired
	private DocumentoMapper mapper;

	@Before
	public void inicializarVariables() {
		documento = new Documento(1, "Documento1", Utilidades.asDate(LocalDate.of(2015, 1, 1)),
				Utilidades.asDate(LocalDate.of(2015, 2, 1)), true, EstadoDocumento.ACTIVO);
	}

	@Test
	public void deberiaInsertarUnDocumento() {
		final int resultado = this.mapper.insertarDocumento(documento);

		assertEquals(1, resultado);
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		this.mapper.insertarDocumento(documento);
		final int resultado = this.mapper.eliminarDocumento(1);

		assertEquals(1, resultado);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		this.mapper.insertarDocumento(documento);
		final int resultado = this.mapper.modificarDocumento(documento);

		assertEquals(1, resultado);
	}

	@Test
	public void deberiaDevolverUnDocumento() {
		this.mapper.insertarDocumento(documento);

		final Documento resultado = this.mapper.listarDocumentos(documento.getCodigo());

		// assertThat(documento, resultado);
	}

	@Test
	public void deberiaActualizarTodosLosCamposDeUnDocumento() {
		final Documento documentoActualizado = new Documento(1, "Documento mod",
				Utilidades.asDate(LocalDate.of(2015, 2, 1)), Utilidades.asDate(LocalDate.of(2015, 2, 2)), false,
				EstadoDocumento.ACTIVO);

		this.mapper.insertarDocumento(this.documento);

		final int resultado = this.mapper.modificarDocumento(documentoActualizado);

		assertThat(resultado, is(1));

		final Documento documentoModificado = this.mapper.listarDocumentos(1);
		assertThat(documentoModificado, is(documentoActualizado));
	}

}
