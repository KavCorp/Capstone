package com.araxsys.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.araxsys.domain.RSVP;
import com.araxsys.repositories.RSVPRepository;

@Service
public class RSVPServiceImpl implements RSVPService {
    private RSVPRepository RSVPRepository;

    @Autowired
    public void setRSVPRepository(RSVPRepository RSVPRepository) {
        this.RSVPRepository = RSVPRepository;
    }

    @Override
    public Iterable<RSVP> listAllRSVPs() {
        return RSVPRepository.findAll();
    }


    @Override
    public RSVP saveRSVP(RSVP RSVP) {
        return RSVPRepository.save(RSVP);
    }

	@Override
	public RSVP getRSVPByEventID(int EventID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RSVP> listAllRSVPsByEvent(int eventID) {
		Iterable<RSVP> list = RSVPRepository.findAll();
		ArrayList<RSVP> returnList = new ArrayList<RSVP>();
		for(RSVP rsvp : list){
			if(rsvp.getCompositePK().getEventId().getEventId()==eventID){
				returnList.add(rsvp);
			}
		}
		
		
		return returnList; 
	}

}
