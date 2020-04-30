/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.simplecaptcha.gimpy;

import static nl.captcha.util.ImageUtil.applyFilter;

import com.jhlabs.image.RippleFilter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

import nl.captcha.gimpy.GimpyRenderer;

/**
 * Copy of nl.captcha.gimpy.RippleGimpyRenderer modified to work with the latest
 * version of com.jhlabs filters.
 *
 * @author James Childers
 * @author Jorge Díaz
 * @review
 */
public class RippleGimpyRenderer implements GimpyRenderer {

	@Override
	public void gimp(BufferedImage bufferedImage) {
		RippleFilter rippleFilter = new RippleFilter();

		rippleFilter.setEdgeAction(RippleFilter.CLAMP);
		rippleFilter.setXAmplitude(2.6F);
		rippleFilter.setXWavelength(15);
		rippleFilter.setYAmplitude(1.7F);
		rippleFilter.setYWavelength(5);

		applyFilter(bufferedImage, new BufferedImageFilter(rippleFilter));
	}

}