package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import daointerfaces01917.ReceptKompDAO;
import dto01917.ProduktBatchKompDTO;
import dto01917.ReceptKompDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLReceptKompDAO implements ReceptKompDAO {
    @Override
    public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = " + receptId + " AND raavare_id = " + raavareId);
        try {
            if (!rs.first()) throw new DALException("Receptkomponent " + receptId + "/" + raavareId + " findes ikke");
            return new ReceptKompDTO (rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
        }
        catch (SQLException e) {throw new DALException(e); }
    }

    @Override
    public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
        List<ReceptKompDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = " + receptId);
        try
        {
            while (rs.next())
            {
                list.add(new ReceptKompDTO (rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    @Override
    public List<ReceptKompDTO> getReceptKompList() throws DALException {
        List<ReceptKompDTO> list = new ArrayList<>();
        ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent");
        try
        {
            while (rs.next())
            {
                list.add(new ReceptKompDTO (rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    @Override
    public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
        Connector.doUpdate(
                "INSERT INTO receptkomponent(recept_id, raavare_id, nom_netto, tolerance) VALUES " +
                        "(" + receptkomponent.getReceptId() + ", '" + receptkomponent.getRaavareId() + "', '" + receptkomponent.getNomNetto() + "', '" + receptkomponent.getTolerance() + "')"
        );
    }

    @Override
    public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
        Connector.doUpdate(
                "UPDATE produktbatchkomponent SET nom_netto = '" + receptkomponent.getNomNetto() + "', tolerance =  '" + receptkomponent.getTolerance() + "' WHERE recept_id = " + receptkomponent.getReceptId() + " AND raavare_id = " + receptkomponent.getRaavareId());
    }

}
