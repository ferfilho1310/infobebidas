package com.example.mostratodasbebidas.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bebida implements Parcelable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("first_brewed")
    private String firstBrewed;
    @SerializedName("description")
    private String description;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("abv")
    private Double abv;
    @SerializedName("ibu")
    private Double ibu;
    @SerializedName("target_fg")
    private Double targetFg;
    @SerializedName("target_og")
    private Double targetOg;
    @SerializedName("ebc")
    private Double ebc;
    @SerializedName("srm")
    private Double srm;
    @SerializedName("ph")
    private Double ph;
    @SerializedName("attenuation_level")
    private Double attenuationLevel;

    protected Bebida(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        tagline = in.readString();
        firstBrewed = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        if (in.readByte() == 0) {
            abv = null;
        } else {
            abv = in.readDouble();
        }
        if (in.readByte() == 0) {
            ibu = null;
        } else {
            ibu = in.readDouble();
        }
        if (in.readByte() == 0) {
            targetFg = null;
        } else {
            targetFg = in.readDouble();
        }
        if (in.readByte() == 0) {
            targetOg = null;
        } else {
            targetOg = in.readDouble();
        }
        if (in.readByte() == 0) {
            ebc = null;
        } else {
            ebc = in.readDouble();
        }
        if (in.readByte() == 0) {
            srm = null;
        } else {
            srm = in.readDouble();
        }
        if (in.readByte() == 0) {
            ph = null;
        } else {
            ph = in.readDouble();
        }
        if (in.readByte() == 0) {
            attenuationLevel = null;
        } else {
            attenuationLevel = in.readDouble();
        }
    }

    public static final Creator<Bebida> CREATOR = new Creator<Bebida>() {
        @Override
        public Bebida createFromParcel(Parcel in) {
            return new Bebida(in);
        }

        @Override
        public Bebida[] newArray(int size) {
            return new Bebida[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }

    public Double getIbu() {
        return ibu;
    }

    public void setIbu(Double ibu) {
        this.ibu = ibu;
    }

    public Double getTargetFg() {
        return targetFg;
    }

    public void setTargetFg(Double targetFg) {
        this.targetFg = targetFg;
    }

    public Double getTargetOg() {
        return targetOg;
    }

    public void setTargetOg(Double targetOg) {
        this.targetOg = targetOg;
    }

    public Double getEbc() {
        return ebc;
    }

    public void setEbc(Double ebc) {
        this.ebc = ebc;
    }

    public Double getSrm() {
        return srm;
    }

    public void setSrm(Double srm) {
        this.srm = srm;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getAttenuationLevel() {
        return attenuationLevel;
    }

    public void setAttenuationLevel(Double attenuationLevel) {
        this.attenuationLevel = attenuationLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tagline='" + tagline + '\'' +
                ", firstBrewed='" + firstBrewed + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", abv=" + abv +
                ", ibu=" + ibu +
                ", targetFg=" + targetFg +
                ", targetOg=" + targetOg +
                ", ebc=" + ebc +
                ", srm=" + srm +
                ", ph=" + ph +
                ", attenuationLevel=" + attenuationLevel +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeString(tagline);
        dest.writeString(firstBrewed);
        dest.writeString(description);
        dest.writeString(imageUrl);
        if (abv == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(abv);
        }
        if (ibu == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(ibu);
        }
        if (targetFg == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(targetFg);
        }
        if (targetOg == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(targetOg);
        }
        if (ebc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(ebc);
        }
        if (srm == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(srm);
        }
        if (ph == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(ph);
        }
        if (attenuationLevel == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(attenuationLevel);
        }
    }
}


