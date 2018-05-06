package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchKompDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO {
    @Override
    public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId + " AND rb_id = " + rbId);
        try {
            if (!rs.first()) throw new DALException("Produktbatchkomponent " + pbId + "/" + rbId + " findes ikke");
            return new ProduktBatchKompDTO (rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
        }
        catch (SQLException e) {throw new DALException(e); }
    }

    @Override
    public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
        List<ProduktBatchKompDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId);
        try
        {
            while (rs.next())
            {
                list.add(new ProduktBatchKompDTO (rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    @Override
    public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
        List<ProduktBatchKompDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
        try
        {
            while (rs.next())
            {
                list.add(new ProduktBatchKompDTO (rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    @Override
    public void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
        Connector.doUpdate(
                "INSERT INTO produktbatchkomponent(pb_id, rb_id, tara, netto, opr_id) VALUES " +
                        "(" + produktbatchkomponent.getPbId() + ", '" + produktbatchkomponent.getRbId() + "', '" + produktbatchkomponent.getTara() + "', '" + produktbatchkomponent.getNetto() + "', '" + produktbatchkomponent.getOprId() + "')"
        );
    }

    @Override
    public void updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
        Connector.doUpdate(
                "UPDATE produktbatchkomponent SET tara = '" + produktbatchkomponent.getTara() + "', netto =  '" + produktbatchkomponent.getNetto() + "' WHERE pb_id = " + produktbatchkomponent.getPbId() + " AND rb_id = " + produktbatchkomponent.getRbId());
    }
}
