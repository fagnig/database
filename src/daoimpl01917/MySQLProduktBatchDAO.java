package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLProduktBatchDAO implements ProduktBatchDAO {

    @Override
    public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pb_id = " + pbId);
        try {
            if (!rs.first()) throw new DALException("Produktbatch " + pbId + " findes ikke");
            return new ProduktBatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
        }
        catch (SQLException e) {throw new DALException(e); }
    }

    @Override
    public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
        List<ProduktBatchDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
        try
        {
            while (rs.next())
            {
                list.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    @Override
    public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
        Connector.doUpdate(
                "INSERT INTO produktbatch(pb_id, status, recept_id) VALUES " +
                        "(" + produktbatch.getPbId() + ", '" + produktbatch.getStatus() + "', '" + produktbatch.getReceptId() + "')"
        );
    }

    @Override
    public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
        Connector.doUpdate(
                "UPDATE produktbatch SET status = '" + produktbatch.getStatus() + "', recept_id =  '" + produktbatch.getReceptId() + "' WHERE opr_id = " + produktbatch.getPbId());
    }
}
