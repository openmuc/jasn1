/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class PhysicalDeliveryCountryName implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public BerNumericString x121DccCode = null;
	public BerPrintableString iso3166Alpha2Code = null;
	
	public PhysicalDeliveryCountryName() {
	}

	public PhysicalDeliveryCountryName(byte[] code) {
		this.code = code;
	}

	public PhysicalDeliveryCountryName(BerNumericString x121DccCode, BerPrintableString iso3166Alpha2Code) {
		this.x121DccCode = x121DccCode;
		this.iso3166Alpha2Code = iso3166Alpha2Code;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (iso3166Alpha2Code != null) {
			codeLength += iso3166Alpha2Code.encode(reverseOS, true);
			return codeLength;
		}
		
		if (x121DccCode != null) {
			codeLength += x121DccCode.encode(reverseOS, true);
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int tlvByteCount = 0;
		boolean tagWasPassed = (berTag != null);

		if (berTag == null) {
			berTag = new BerTag();
			tlvByteCount += berTag.decode(is);
		}

		if (berTag.equals(BerNumericString.tag)) {
			x121DccCode = new BerNumericString();
			tlvByteCount += x121DccCode.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerPrintableString.tag)) {
			iso3166Alpha2Code = new BerPrintableString();
			tlvByteCount += iso3166Alpha2Code.decode(is, false);
			return tlvByteCount;
		}

		if (tagWasPassed) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (x121DccCode != null) {
			sb.append("x121DccCode: ").append(x121DccCode);
			return;
		}

		if (iso3166Alpha2Code != null) {
			sb.append("iso3166Alpha2Code: ").append(iso3166Alpha2Code);
			return;
		}

		sb.append("<none>");
	}

}

