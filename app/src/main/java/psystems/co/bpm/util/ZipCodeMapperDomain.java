package psystems.co.bpm.util;



import javax.inject.Inject;

import psystems.co.bpm.api.model.response.TableElement;
import psystems.co.bpm.domain.model.ZipCodeDomain;

public class ZipCodeMapperDomain extends EntityMapper<ZipCodeDomain,TableElement> {

    @Inject
    public ZipCodeMapperDomain() {
    }

    @Override
    public TableElement map(ZipCodeDomain element) {
        TableElement element1 = new TableElement();
        element1.setCity(element.getCity());
        element1.setTimeZone(element.getTimeZone());
        element1.setAreaCode(element.getAreaCode());
        element1.setState(element.getState());
        element1.setZip(element.getZipCode());
        return element1;
    }

    @Override
    public ZipCodeDomain reverseMap(TableElement element) {
        ZipCodeDomain codeData = new ZipCodeDomain();
        codeData.setCity(element.getCity());
        codeData.setState(element.getState());
        codeData.setAreaCode(element.getAreaCode());
        codeData.setTimeZone(element.getTimeZone());
        codeData.setZipCode(element.getZip());
        return codeData;
    }
}
