
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
 * <p>Original entity name from the Odata EDM: <b>Products_by_Category</b></p>
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
public class Products_by_Category
    extends VdmEntity<Products_by_Category>
    implements VdmEntitySet
{

    @Getter
    private final java.lang.String odataType = "NorthwindModel.Products_by_Category";
    /**
     * Selector for all available fields of Products_by_Category.
     * 
     */
    public final static SimpleProperty<Products_by_Category> ALL_FIELDS = all();
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>CategoryName</b></p>
     * 
     * @return
     *     The categoryName contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("CategoryName")
    private java.lang.String categoryName;
    public final static SimpleProperty.String<Products_by_Category> CATEGORY_NAME = new SimpleProperty.String<Products_by_Category>(Products_by_Category.class, "CategoryName");
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>ProductName</b></p>
     * 
     * @return
     *     The productName contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("ProductName")
    private java.lang.String productName;
    public final static SimpleProperty.String<Products_by_Category> PRODUCT_NAME = new SimpleProperty.String<Products_by_Category>(Products_by_Category.class, "ProductName");
    /**
     * Constraints: Nullable<p>Original property name from the Odata EDM: <b>QuantityPerUnit</b></p>
     * 
     * @return
     *     The quantityPerUnit contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("QuantityPerUnit")
    private java.lang.String quantityPerUnit;
    public final static SimpleProperty.String<Products_by_Category> QUANTITY_PER_UNIT = new SimpleProperty.String<Products_by_Category>(Products_by_Category.class, "QuantityPerUnit");
    /**
     * Constraints: Nullable<p>Original property name from the Odata EDM: <b>UnitsInStock</b></p>
     * 
     * @return
     *     The unitsInStock contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("UnitsInStock")
    private Short unitsInStock;
    public final static SimpleProperty.NumericInteger<Products_by_Category> UNITS_IN_STOCK = new SimpleProperty.NumericInteger<Products_by_Category>(Products_by_Category.class, "UnitsInStock");
    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>Discontinued</b></p>
     * 
     * @return
     *     The discontinued contained in this {@link VdmEntity}.
     */
    @Nullable
    @ElementName("Discontinued")
    private java.lang.Boolean discontinued;
    public final static SimpleProperty.Boolean<Products_by_Category> DISCONTINUED = new SimpleProperty.Boolean<Products_by_Category>(Products_by_Category.class, "Discontinued");

    @Nonnull
    @Override
    public Class<Products_by_Category> getType() {
        return Products_by_Category.class;
    }

    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>CategoryName</b></p>
     * 
     * @param categoryName
     *     The categoryName to set.
     */
    public void setCategoryName(
        @Nullable
        final java.lang.String categoryName) {
        rememberChangedField("CategoryName", this.categoryName);
        this.categoryName = categoryName;
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

    /**
     * Constraints: Nullable<p>Original property name from the Odata EDM: <b>QuantityPerUnit</b></p>
     * 
     * @param quantityPerUnit
     *     The quantityPerUnit to set.
     */
    public void setQuantityPerUnit(
        @Nullable
        final java.lang.String quantityPerUnit) {
        rememberChangedField("QuantityPerUnit", this.quantityPerUnit);
        this.quantityPerUnit = quantityPerUnit;
    }

    /**
     * Constraints: Nullable<p>Original property name from the Odata EDM: <b>UnitsInStock</b></p>
     * 
     * @param unitsInStock
     *     The unitsInStock to set.
     */
    public void setUnitsInStock(
        @Nullable
        final Short unitsInStock) {
        rememberChangedField("UnitsInStock", this.unitsInStock);
        this.unitsInStock = unitsInStock;
    }

    /**
     * (Key Field) Constraints: Not nullable<p>Original property name from the Odata EDM: <b>Discontinued</b></p>
     * 
     * @param discontinued
     *     The discontinued to set.
     */
    public void setDiscontinued(
        @Nullable
        final java.lang.Boolean discontinued) {
        rememberChangedField("Discontinued", this.discontinued);
        this.discontinued = discontinued;
    }

    @Override
    protected java.lang.String getEntityCollection() {
        return "Products_by_Categories";
    }

    @Nonnull
    @Override
    protected ODataEntityKey getKey() {
        final ODataEntityKey entityKey = super.getKey();
        entityKey.addKeyProperty("CategoryName", getCategoryName());
        entityKey.addKeyProperty("ProductName", getProductName());
        entityKey.addKeyProperty("Discontinued", getDiscontinued());
        return entityKey;
    }

    @Nonnull
    @Override
    protected Map<java.lang.String, Object> toMapOfFields() {
        final Map<java.lang.String, Object> cloudSdkValues = super.toMapOfFields();
        cloudSdkValues.put("CategoryName", getCategoryName());
        cloudSdkValues.put("ProductName", getProductName());
        cloudSdkValues.put("QuantityPerUnit", getQuantityPerUnit());
        cloudSdkValues.put("UnitsInStock", getUnitsInStock());
        cloudSdkValues.put("Discontinued", getDiscontinued());
        return cloudSdkValues;
    }

    @Override
    protected void fromMap(final Map<java.lang.String, Object> inputValues) {
        final Map<java.lang.String, Object> cloudSdkValues = Maps.newLinkedHashMap(inputValues);
        // simple properties
        {
            if (cloudSdkValues.containsKey("CategoryName")) {
                final Object value = cloudSdkValues.remove("CategoryName");
                if ((value == null)||(!value.equals(getCategoryName()))) {
                    setCategoryName(((java.lang.String) value));
                }
            }
            if (cloudSdkValues.containsKey("ProductName")) {
                final Object value = cloudSdkValues.remove("ProductName");
                if ((value == null)||(!value.equals(getProductName()))) {
                    setProductName(((java.lang.String) value));
                }
            }
            if (cloudSdkValues.containsKey("QuantityPerUnit")) {
                final Object value = cloudSdkValues.remove("QuantityPerUnit");
                if ((value == null)||(!value.equals(getQuantityPerUnit()))) {
                    setQuantityPerUnit(((java.lang.String) value));
                }
            }
            if (cloudSdkValues.containsKey("UnitsInStock")) {
                final Object value = cloudSdkValues.remove("UnitsInStock");
                if ((value == null)||(!value.equals(getUnitsInStock()))) {
                    setUnitsInStock(((Short) value));
                }
            }
            if (cloudSdkValues.containsKey("Discontinued")) {
                final Object value = cloudSdkValues.remove("Discontinued");
                if ((value == null)||(!value.equals(getDiscontinued()))) {
                    setDiscontinued(((java.lang.Boolean) value));
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
