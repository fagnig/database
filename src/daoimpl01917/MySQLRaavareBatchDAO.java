package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLRaavareBatchDAO implements RaavareBatchDAO {
    @Override
    public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE rb_id = " + rbId);
        try {
            if (!rs.first()) throw new DALException("Råvarebatchet " + rbId + " findes ikke");
            return new RaavareBatchDTO (rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde"));
        }
        catch (SQLException e) {throw new DALException(e); }
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
        List<RaavareBatchDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch");
        try
        {
            while (rs.next())
            {
                list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    @Override
    public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
        List<RaavareBatchDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM raavarebatch WHERE raavare_id = " + raavareId);
        try
        {
            while (rs.next())
            {
                list.add(new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getDouble("maengde")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    @Override
    public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        Connector.doUpdate(
                "INSERT INTO raavarebatch(rb_id, raavare_id, maengde) VALUES " +
                        "(" + raavarebatch.getRbId() + ", '" + raavarebatch.getRaavareId() + "', '" + raavarebatch.getMaengde() + "')"
        );
    }

    @Override
    public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
        Connector.doUpdate(
                "UPDATE raavarebatch SET raavare_id = '" + raavarebatch.getRaavareId() + "', maengde =  '" + raavarebatch.getMaengde() + "' WHERE pb_id = " + raavarebatch.getRbId());
    }
}
