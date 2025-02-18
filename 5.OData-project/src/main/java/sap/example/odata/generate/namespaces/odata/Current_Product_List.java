
/*
 * Generated by OData VDM code generator of SAP Cloud SDK in version 5.16.0
 */

package sap.example.odata.generate.namespaces.odata;

import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Maps;
import com.google.gson.annotations.JsonAdapter;
import com.sap.cloud.sdk.datamodel.odata.client.request.ODataEntityKey;
import com.sap.cloud.sdk.datamodel.odatav4.core.SimpleProperty;
import com.sap.cloud.sdk.datamodel.odatav4.core.VdmEntity;
import com.sap.cloud.sdk.datamodel.odatav4.core.VdmEntitySet;
import com.sap.cloud.sdk.result.ElementName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sap.example.odata.generate.services.OdataService;


/**
 * <p>Original entity name from the Odata EDM: <b>Current_Product_List</b></p>
 * 
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true, callSuper = true)
@EqualsAndHashCode(doNotUseGetters = true, callSuper = true)
@JsonAdapter(com.sap.cloud.sdk.datamodel.odatav4.adapter.GsonVdmAdapterFactory.class)
@JsonSerialize(using = com.sap.cloud.sdk.datamodel.odatav4.adapter.JacksonVdmObjectSerializer.class)
@JsonDeserialize(using = com.sap.cloud.sdk.datamodel.odatav4.adapter.JacksonVdmObjectDeserializer.class)
public class Current_Product_List
    extends VdmEntity<Current_Product_List>
    implements VdmEntitySet
{

    @Getter
    private final java.lang.String odataType = "NorthwindModel.Current_Product_List";
    /**
     * Selector for all available fields of Current_Product_List.
     * 
     */
    public final static SimpleProperty<Current_Product_List> ALL_FIELDS = all();
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>ProductID</b></p>
     * 
     * @return
     *     The productID contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("ProductID")
    private Integer productID;
    public final static SimpleProperty.NumericInteger<Current_Product_List> PRODUCT_ID = new SimpleProperty.NumericInteger<Current_Product_List>(Current_Product_List.class, "ProductID");
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>ProductName</b></p>
     * 
     * @return
     *     The productName contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("ProductName")
    private java.lang.String productName;
    public final static SimpleProperty.String<Current_Product_List> PRODUCT_NAME = new SimpleProperty.String<Current_Product_List>(Current_Product_List.class, "ProductName");

    @Nonnull
    @Override
    public Class<Current_Product_List> getType() {
        return Current_Product_List.class;
    }

    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>ProductID</b></p>
     * 
     * @param productID
     *     The productID to set.
     */
    public void setProductID(
        @Nullable
        final Integer productID) {
        rememberChangedField("ProductID", this.productID);
        this.productID = productID;
    }

    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>ProductName</b></p>
     * 
     * @param productName
     *     The productName to set.
     */
    public void setProductName(
        @Nullable
        final java.lang.String productName) {
        rememberChangedField("ProductName", this.productName);
        this.productName = productName;
    }

    @Override
    protected java.lang.String getEntityCollection() {
        return "Current_Product_Lists";
    }

    @Nonnull
    @Override
    protected ODataEntityKey getKey() {
        final ODataEntityKey entityKey = super.getKey();
        entityKey.addKeyProperty("ProductID", getProductID());
        entityKey.addKeyProperty("ProductName", getProductName());
        return entityKey;
    }

    @Nonnull
    @Override
    protected Map<java.lang.String, Object> toMapOfFields() {
        final Map<java.lang.String, Object> cloudSdkValues = super.toMapOfFields();
        cloudSdkValues.put("ProductID", getProductID());
        cloudSdkValues.put("ProductName", getProductName());
        return cloudSdkValues;
    }

    @Override
    protected void fromMap(final Map<java.lang.String, Object> inputValues) {
        final Map<java.lang.String, Object> cloudSdkValues = Maps.newLinkedHashMap(inputValues);
        // simple properties
        {
            if (cloudSdkValues.containsKey("ProductID")) {
                final Object value = cloudSdkValues.remove("ProductID");
                if ((value == null)||(!value.equals(getProductID()))) {
                    setProductID(((Integer) value));
                }
            }
            if (cloudSdkValues.containsKey("ProductName")) {
                final Object value = cloudSdkValues.remove("ProductName");
                if ((value == null)||(!value.equals(getProductName()))) {
                    setProductName(((java.lang.String) value));
                }
            }
        }
        // structured properties
        {
        }
        // navigation properties
        {
        }
        super.fromMap(cloudSdkValues);
    }

    @Override
    protected java.lang.String getDefaultServicePath() {
        return OdataService.DEFAULT_SERVICE_PATH;
    }

}
