/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.renderer;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jorge Ferrer
 */
@ProviderType
public interface FragmentRendererTracker {

	public FragmentRenderer getFragmentRenderer(String key);

	public List<FragmentRenderer> getFragmentRenderers();

	public List<FragmentRenderer> getFragmentRenderers(int type);

}