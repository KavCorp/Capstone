package com.araxsys.services;

import com.araxsys.domain.RSVP;

public interface RSVPService {
	Iterable<RSVP>  listAllRSVPs();

	RSVP saveRSVP(RSVP RSVP);

	RSVP getRSVPByEventID(int EventID);

}