/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSFieldVisitor<S> {

	public S getObject();

	public S visit(ApproveDSField approveDSField);

	public S visit(CheckboxDSField checkboxDSField);

	public S visit(CompanyNameDSField companyNameDSField);

	public S visit(DateDSField dateDSField);

	public S visit(DateSignedDSField dateSignedDSField);

	public S visit(DeclineDSField declineDSField);

	public S visit(EmailAddressDSField emailAddressDSField);

	public S visit(FirstNameDSField firstNameDSField);

	public S visit(FormulaDSField formulaDSField);

	public S visit(FullNameDSField fullNameDSField);

	public S visit(InitialHereDSField initialHereDSField);

	public S visit(LastNameDSField lastNameDSField);

	public S visit(ListDSField listDSField);

	public S visit(NotarizeDSField notarizeDSField);

	public S visit(NoteDSField noteDSField);

	public S visit(NumberDSField numberDSField);

	public S visit(
		ParticipantEmailAddressDSField participantEmailAddressDSField);

	public S visit(PostalCodeDSField postalCodeDSField);

	public S visit(RadioDSField radioDSField);

	public S visit(RadioGroupDSField radioGroupDSField);

	public S visit(SignaturePackageKeyDSField signaturePackageKeyDSField);

	public S visit(SignerAttachmentDSField signerAttachmentDSField);

	public S visit(SignHereDSField signHereDSField);

	public S visit(SocialSecurityNumberDSField socialSecurityNumberDSField);

	public S visit(TextDSField textDSField);

	public S visit(TitleDSField titleDSField);

	public S visit(ViewDSField viewDSField);

}