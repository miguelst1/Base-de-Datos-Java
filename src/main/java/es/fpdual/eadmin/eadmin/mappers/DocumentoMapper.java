package es.fpdual.eadmin.eadmin.mappers;

import org.apache.ibatis.annotations.Param;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {

	int insertarDocumento(@Param("documento") Documento documento);

}
