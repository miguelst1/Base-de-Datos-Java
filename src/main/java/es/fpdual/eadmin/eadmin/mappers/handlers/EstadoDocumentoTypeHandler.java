package es.fpdual.eadmin.eadmin.mappers.handlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

@MappedTypes(EstadoDocumento.class)
public class EstadoDocumentoTypeHandler implements TypeHandler<EstadoDocumento> {

	@Override
	public EstadoDocumento getResult(ResultSet rs, String arg1) throws SQLException {
		return EstadoDocumento.obtenerPorCodigo(rs.getInt(arg1));
	}

	@Override
	public EstadoDocumento getResult(ResultSet rs, int arg1) throws SQLException {
		return EstadoDocumento.obtenerPorCodigo(rs.getInt(arg1));
	}

	@Override
	public EstadoDocumento getResult(CallableStatement cs, int arg1) throws SQLException {
		return EstadoDocumento.obtenerPorCodigo(cs.getInt(arg1));
	}

	@Override
	public void setParameter(PreparedStatement ps, int columnIndex, EstadoDocumento estadoDocumento, JdbcType arg3)
			throws SQLException {
		ps.setInt(columnIndex, estadoDocumento.getCodigo());
	}

}
