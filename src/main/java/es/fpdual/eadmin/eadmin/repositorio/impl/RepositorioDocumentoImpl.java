package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.mappers.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private DocumentoMapper mapper;
	private List<Documento> documentos = new ArrayList<>();

	@Autowired
	public RepositorioDocumentoImpl(DocumentoMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void altaDocumento(Documento documento) {
		this.mapper.insertarDocumento(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
		this.mapper.modificarDocumento(documento);
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		this.mapper.eliminarDocumento(codigo);
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		return this.mapper.listarDocumentos(codigo);
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		return this.documentos;
	}

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {

		return documento.getCodigo().equals(codigo);
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

}
