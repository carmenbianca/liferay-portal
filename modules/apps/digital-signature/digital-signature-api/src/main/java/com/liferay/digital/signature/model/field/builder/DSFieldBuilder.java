/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field.builder;

import com.liferay.digital.signature.model.field.AnchorUnits;
import com.liferay.digital.signature.model.field.DSField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSFieldBuilder<T extends DSField<?>> {

	public DSField<T> getDSField();

	public <S> S setAnchorIgnoreIfNotPresent(Boolean anchorIgnoreIfNotPresent);

	public <S> S setAnchorString(String anchorString);

	public <S> S setAnchorUnits(AnchorUnits anchorUnits);

	public <S> S setAnchorXOffset(Float anchorXOffset);

	public <S> S setAnchorYOffset(Float anchorYOffset);

	public <S> S setConditionalParentLabel(String conditionalParentLabel);

	public <S> S setConditionalParentValue(String conditionalParentValue);

	public <S> S setFieldLabel(String fieldLabel);

	public <S> S setFieldOrder(Integer fieldOrder);

	public <S> S setLocked(Boolean locked);

	public <S> S setName(String name);

	public <S> S setParticipantKey(String participantKey);

	public <S> S setRequireAll(Boolean requireAll);

	public <S> S setRequired(Boolean required);

	public <S> S setShared(Boolean shared);

	public <S> S setTemplateLocked(Boolean templateLocked);

	public <S> S setTemplateRequired(Boolean templateRequired);

	public <S> S setXPosition(Float xPosition);

	public <S> S setYPosition(Float yPosition);

}