package com.mx.mwisp.mwsipfinal.converterInterface;
import java.util.List;

import com.mx.mwisp.mwsipfinal.model.RouterModel;
import com.mx.mwisp.mwsipfinal.entity.Router;

public interface ConverterRouterInterface {
	public RouterModel entityRouterToDtoRouter(Router entityRouter);
	public List<RouterModel> listEntityRouterToListDtoRouter(List<Router> listEntityRouter);
	public Router DtoRouterToEntityRouter(RouterModel dtoRouter);
	public List<Router> listDtoRouterTolistEntityRouter(List<RouterModel> listDtoRouter);
}
