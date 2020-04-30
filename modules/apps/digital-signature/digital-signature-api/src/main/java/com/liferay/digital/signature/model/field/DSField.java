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
public interface DSField<T extends DSField<?>> {

	public Boolean getAnchorIgnoreIfNotPresent();

	public String getAnchorString();

	public AnchorUnits getAnchorUnits();

	public Float getAnchorXOffset();

	public Float getAnchorYOffset();

	public String getConditionalParentLabel();

	public String getConditionalParentValue();

	public String getDocumentKey();

	public String getFieldKey();

	public String getFieldLabel();

	public Integer getFieldOrder();

	public Boolean getLocked();

	public String getName();

	public Integer getPageNumber();

	public String getParticipantKey();

	public Boolean getRequireAll();

	public Boolean getRequired();

	public Boolean getShared();

	public Boolean getTemplateLocked();

	public Boolean getTemplateRequired();

	public Float getXPosition();

	public Float getYPosition();

	public <S> S visit(DSFieldVisitor<S> dsFieldVisitor);

}