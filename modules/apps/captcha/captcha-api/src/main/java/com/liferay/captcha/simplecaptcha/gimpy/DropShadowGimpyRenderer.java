/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.simplecaptcha.gimpy;

import static nl.captcha.util.ImageUtil.applyFilter;

import com.jhlabs.image.ShadowFilter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

import nl.captcha.gimpy.GimpyRenderer;

/**
 * Copy of nl.captcha.gimpy.DropShadowGimpyRenderer modified to work with the
 * latest version of com.jhlabs filters.
 *
 * @author James Childers
 * @author Jorge Díaz
 * @review
 */
public class DropShadowGimpyRenderer implements GimpyRenderer {

	public DropShadowGimpyRenderer() {
		this(3, 75);
	}

	public DropShadowGimpyRenderer(int radius, int opacity) {
		_radius = radius;
		_opacity = opacity;
	}

	@Override
	public void gimp(BufferedImage bufferedImage) {
		ShadowFilter shadowFilter = new ShadowFilter();

		shadowFilter.setOpacity(_opacity / 100F);
		shadowFilter.setRadius(_radius);

		applyFilter(bufferedImage, new BufferedImageFilter(shadowFilter));
	}

	private final int _opacity;
	private final int _radius;

}