/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.builder;

import com.liferay.digital.signature.internal.model.DSSignatureInfoImpl;
import com.liferay.digital.signature.internal.model.SignerDSParticipantImpl;
import com.liferay.digital.signature.model.DSParticipant;
import com.liferay.digital.signature.model.DSSignatureInfo;
import com.liferay.digital.signature.model.builder.DSParticipantBuilder;
import com.liferay.digital.signature.model.builder.SigningDSParticipantBuilder;
import com.liferay.digital.signature.model.field.DSField;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael C. Han
 */
public abstract class BaseSigningDSParticipantBuilderImpl
	<T extends DSParticipant>
		extends BaseDSParticipantBuilderImpl<T>
		implements SigningDSParticipantBuilder {

	public BaseSigningDSParticipantBuilderImpl(
		String emailAddress, String name, int routingOrder) {

		super(emailAddress, name, routingOrder);
	}

	@Override
	public <S extends DSParticipantBuilder> S addDSField(DSField<?> dsField) {
		_dsFields.add(dsField);

		return (S)this;
	}

	@Override
	public <S extends DSParticipantBuilder> S addDSFields(
		Collection<DSField<?>> dsFields) {

		_dsFields.addAll(dsFields);

		return (S)this;
	}

	@Override
	public <S extends DSParticipantBuilder> S addDSFields(
		DSField<?>... dsFields) {

		Collections.addAll(_dsFields, dsFields);

		return (S)this;
	}

	@Override
	public <S extends DSParticipantBuilder> S setAutoNavigation(
		Boolean autoNavigation) {

		_autoNavigation = autoNavigation;

		return (S)this;
	}

	@Override
	public <S extends DSParticipantBuilder> S setDefaultParticipant(
		Boolean defaultParticipant) {

		_defaultParticipant = defaultParticipant;

		return (S)this;
	}

	@Override
	public <S extends DSParticipantBuilder> S setSignatureInfo(
		String signatureFont, String signatureInitials, String signatureName) {

		_dsSignatureInfo = new DSSignatureInfoImpl() {
			{
				setSignatureFont(signatureFont);
				setSignatureInitials(signatureInitials);
				setSignatureName(signatureName);
			}
		};

		return (S)this;
	}

	@Override
	public <S extends DSParticipantBuilder> S setSignInEachLocation(
		Boolean signInEachLocation) {

		_signInEachLocation = signInEachLocation;

		return (S)this;
	}

	@Override
	protected T createDSParticipant() {
		SignerDSParticipantImpl signerDSParticipantImpl =
			createSignerDSParticipantImpl();

		signerDSParticipantImpl.addDSFields(getDSFields());
		signerDSParticipantImpl.setAutoNavigation(getAutoNavigation());
		signerDSParticipantImpl.setDefaultParticipant(getDefaultParticipant());
		signerDSParticipantImpl.setDSSignatureInfo(getDSSignatureInfo());
		signerDSParticipantImpl.setSignInEachLocation(getSignInEachLocation());

		return (T)signerDSParticipantImpl;
	}

	protected abstract SignerDSParticipantImpl createSignerDSParticipantImpl();

	protected Boolean getAutoNavigation() {
		return _autoNavigation;
	}

	protected Boolean getDefaultParticipant() {
		return _defaultParticipant;
	}

	protected Set<DSField<?>> getDSFields() {
		return _dsFields;
	}

	protected DSSignatureInfo getDSSignatureInfo() {
		return _dsSignatureInfo;
	}

	protected Boolean getSignInEachLocation() {
		return _signInEachLocation;
	}

	private Boolean _autoNavigation;
	private Boolean _defaultParticipant;
	private Set<DSField<?>> _dsFields = new HashSet<>();
	private DSSignatureInfo _dsSignatureInfo;
	private Boolean _signInEachLocation;

}