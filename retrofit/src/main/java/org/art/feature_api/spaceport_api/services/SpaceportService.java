package org.art.feature_api.spaceport_api.services;

import org.art.retrofit.BaseHttpMethodsService;
import org.art.retrofit.setup.Service;
import org.art.retrofit.setup.ServiceType;

@Service(type = ServiceType.LOCALHOST_84, path = "spaceport/")
public interface SpaceportService extends BaseHttpMethodsService {

    String GET_ALL_EP = "all";
}
