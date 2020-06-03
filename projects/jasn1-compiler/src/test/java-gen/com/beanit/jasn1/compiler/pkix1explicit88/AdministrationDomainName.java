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


public class AdministrationDomainName implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 2);

	public BerNumericString numeric = null;
	public BerPrintableString printable = null;
	
	public AdministrationDomainName() {
	}

	public AdministrationDomainName(byte[] code) {
		this.code = code;
	}

	public AdministrationDomainName(BerNumericString numeric, BerPrintableString printable) {
		this.numeric = numeric;
		this.printable = printable;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (printable != null) {
			codeLength += printable.encode(reverseOS, true);
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (numeric != null) {
			codeLength += numeric.encode(reverseOS, true);
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlvByteCount = 0;
		BerLength length = new BerLength();
		BerTag berTag = new BerTag();

		if (withTag) {
			tlvByteCount += tag.decodeAndCheck(is);
		}

		tlvByteCount += length.decode(is);
		tlvByteCount += berTag.decode(is);

		if (berTag.equals(BerNumericString.tag)) {
			numeric = new BerNumericString();
			tlvByteCount += numeric.decode(is, false);
			return tlvByteCount;
		}

		if (berTag.equals(BerPrintableString.tag)) {
			printable = new BerPrintableString();
			tlvByteCount += printable.decode(is, false);
			return tlvByteCount;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (numeric != null) {
			sb.append("numeric: ").append(numeric);
			return;
		}

		if (printable != null) {
			sb.append("printable: ").append(printable);
			return;
		}

		sb.append("<none>");
	}

}

