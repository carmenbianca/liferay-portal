/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.renderer;

import com.liferay.fragment.model.FragmentEntryLink;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jorge Ferrer
 */
@ProviderType
public interface FragmentRendererContext {

	public Optional<Object> getDisplayObjectOptional();

	public Optional<Map<String, Object>> getFieldValuesOptional();

	public FragmentEntryLink getFragmentEntryLink();

	public Locale getLocale();

	public String getMode();

	public long getPreviewClassNameId();

	public long getPreviewClassPK();

	public int getPreviewType();

	public long[] getSegmentsExperienceIds();

}