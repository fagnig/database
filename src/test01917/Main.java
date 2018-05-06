package test01917;

import daoimpl01917.*;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.*;

import java.sql.SQLException;

import connector01917.Connector;

public class Main {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("Operatoer nummer 3:");
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		try { System.out.println(opr.getOperatoer(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny operatoer med opr_id =  4");
		OperatoerDTO oprDTO = new OperatoerDTO(4,"Don Juan","DJ","000000-0000","iloveyou");
		try { opr.createOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af initialer for operatoer nummer 4");
		oprDTO.setIni("DoJu");
		try { opr.updateOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle operatoerer:");
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operatoer nummer 5:");
		try { System.out.println(opr.getOperatoer(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }




        System.out.println("Testing new classes from now:");
		//-----------------------------------------------------//
		//-----------------MySQLProduktBatchDTO----------------//
		//-----------------------------------------------------//

		MySQLProduktBatchDAO pbtch = new MySQLProduktBatchDAO();
		System.out.println("Produktbatch 2:");
		try {
			System.out.println(pbtch.getProduktBatch(2));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Oprettelse af ny produktbatch:");
		ProduktBatchDTO pb = new ProduktBatchDTO(10, 0, 4);
		try {
			pbtch.createProduktBatch(pb);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Produktbatch 10:");
		try {
			System.out.println(pbtch.getProduktBatch(10));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Redigering af status på produktbatch 10:");
		pb.setStatus(2);
		try {
			pbtch.updateProduktBatch(pb);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Produktbatch 10:");
		try {
			System.out.println(pbtch.getProduktBatch(10));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Alle produktbatches:");
		try {
			System.out.println(pbtch.getProduktBatchList());
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Produktbatch 50:");
		try {
			System.out.println(pbtch.getProduktBatch(50));
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}

        //-----------------------------------------------------//
        //---------------MySQLProduktBatchKompDTO--------------//
        //-----------------------------------------------------//

        MySQLProduktBatchKompDAO pbtchk = new MySQLProduktBatchKompDAO();
        System.out.println("Produktbatchkomp 2/2:");
        try {
            System.out.println(pbtchk.getProduktBatchKomp(2, 2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Oprettelse af ny produktbatchkomp 6/6:");
        ProduktBatchKompDTO pbk = new ProduktBatchKompDTO(6, 6, 4, 1, 2);
        try {
            pbtchk.createProduktBatchKomp(pbk);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Produktbatch 6/6:");
        try {
            System.out.println(pbtchk.getProduktBatchKomp(6,6));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Redigering af netto på produktbatchkomp 6/6:");
        pbk.setNetto(10);
        try {
            pbtchk.updateProduktBatchKomp(pbk);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Produktbatch 6/6:");
        try {
            System.out.println(pbtchk.getProduktBatchKomp(6,6));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle produktbatchkomponenter:");
        try {
            System.out.println(pbtchk.getProduktBatchKompList());
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle produktbatchkomponenter med produktbatchid 2:");
        try {
            System.out.println(pbtchk.getProduktBatchKompList(2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Produktbatchkomponent 50/50:");
        try {
            System.out.println(pbtchk.getProduktBatchKomp(50, 50));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        //-----------------------------------------------------//
        //-----------------MySQLPRaavareBatchDTO---------------//
        //-----------------------------------------------------//

        MySQLRaavareBatchDAO rbtch = new MySQLRaavareBatchDAO();
        System.out.println("Raavarebatch 2:");
        try {
            System.out.println(rbtch.getRaavareBatch(2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Oprettelse af ny raavarebatch:");
        RaavareBatchDTO rb = new RaavareBatchDTO(10, 2, 10);
        try {
            rbtch.createRaavareBatch(rb);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Raavarebatch 10:");
        try {
            System.out.println(rbtch.getRaavareBatch(10));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Redigering af maegnde på raavarebatch 10:");
        rb.setMaengde(500);
        try {
            rbtch.updateRaavareBatch(rb);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Raavarebatch 10:");
        try {
            System.out.println(rbtch.getRaavareBatch(10));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle raavarebatches:");
        try {
            System.out.println(rbtch.getRaavareBatchList());
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle raavarebatches med raavare_id 2:");
        try {
            System.out.println(rbtch.getRaavareBatchList(2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Raavarebatch 50:");
        try {
            System.out.println(rbtch.getRaavareBatch(50));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        //-----------------------------------------------------//
        //------------------MySQLRaavareDTO--------------------//
        //-----------------------------------------------------//

        MySQLRaavareDAO rvd = new MySQLRaavareDAO();
        System.out.println("Raavare 2:");
        try {
            System.out.println(rvd.getRaavare(2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Oprettelse af ny raavare:");
        RaavareDTO rv = new RaavareDTO(10, "kafe", "god");
        try {
            rvd.createRaavare(rv);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Raavare 10:");
        try {
            System.out.println(rvd.getRaavare(10));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Redigering af leverandoer på raavare 10:");
        rv.setLeverandoer("daarlig");
        try {
            rvd.updateRaavare(rv);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Raavare 10:");
        try {
            System.out.println(rvd.getRaavare(10));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle Raavarer:");
        try {
            System.out.println(rvd.getRaavareList());
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Raavare 50:");
        try {
            System.out.println(rvd.getRaavare(50));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        //-----------------------------------------------------//
        //-------------------MySQLReceptDTO--------------------//
        //-----------------------------------------------------//

        MySQLReceptDAO rcd = new MySQLReceptDAO();
        System.out.println("Recept 2:");
        try {
            System.out.println(rcd.getRecept(2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Oprettelse af ny recept:");
        ReceptDTO rc = new ReceptDTO(10, "kafe");
        try {
            rcd.createRecept(rc);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Recept 10:");
        try {
            System.out.println(rcd.getRecept(10));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Redigering af navn på raavare 10:");
        rc.setReceptNavn("kaf  e");
        try {
            rcd.updateRecept(rc);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Recept 10:");
        try {
            System.out.println(rcd.getRecept(10));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle Recepter:");
        try {
            System.out.println(rcd.getReceptList());
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Recept 50:");
        try {
            System.out.println(rcd.getRecept(50));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        //-----------------------------------------------------//
        //------------------MySQLReceptKompDTO-----------------//
        //-----------------------------------------------------//

        MySQLReceptKompDAO rckd = new MySQLReceptKompDAO();
        System.out.println("Receptkomp 2/2:");
        try {
            System.out.println(rckd.getReceptKomp(2, 2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Oprettelse af ny receptkomp 6/6:");
        ReceptKompDTO rck = new ReceptKompDTO(6, 6, 4, 1);
        try {
            rckd.createReceptKomp(rck);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Receptkomp 6/6:");
        try {
            System.out.println(rckd.getReceptKomp(6,6));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Redigering af nomnetto på receptkomp 6/6:");
        rck.setNomNetto(10);
        try {
            rckd.updateReceptKomp(rck);
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Receptkomp 6/6:");
        try {
            System.out.println(rckd.getReceptKomp( 6,6));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle Receptkomponenter:");
        try {
            System.out.println(rckd.getReceptKompList());
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alle receptkomponenter med receptid 2:");
        try {
            System.out.println(rckd.getReceptKompList(2));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Receptkomponent 50/50:");
        try {
            System.out.println(rckd.getReceptKomp(50, 50));
        } catch (DALException e) {
            System.out.println(e.getMessage());
        }
	}
}
