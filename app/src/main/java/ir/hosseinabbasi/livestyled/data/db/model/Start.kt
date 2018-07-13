package ir.hosseinabbasi.livestyled.data.db.model


import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


@Generated("com.robohorse.robopojogenerator")
open class Start(

	@field:SerializedName("dateTime")
	open var dateTime: String? = null,

	@field:SerializedName("localTime")
	open var localTime: String? = null,

	@field:SerializedName("dateTBA")
	open var dateTBA: Boolean? = null,

	@field:SerializedName("noSpecificTime")
	open var noSpecificTime: Boolean? = null,

	@field:SerializedName("timeTBA")
	open var timeTBA: Boolean? = null,

	@field:SerializedName("localDate")
	open var localDate: String? = null,

	@field:SerializedName("dateTBD")
	open var dateTBD: Boolean? = null
) : RealmObject()