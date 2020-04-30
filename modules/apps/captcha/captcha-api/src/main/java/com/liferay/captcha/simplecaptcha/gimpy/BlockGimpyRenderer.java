/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.simplecaptcha.gimpy;

import static nl.captcha.util.ImageUtil.applyFilter;

import com.jhlabs.image.BlockFilter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

import nl.captcha.gimpy.GimpyRenderer;

/**
 * Copy of nl.captcha.gimpy.BlockGimpyRenderer modified to work with the latest
 * version of com.jhlabs filters.
 *
 * @author James Childers
 * @author Jorge Díaz
 * @review
 */
public class BlockGimpyRenderer implements GimpyRenderer {

	public BlockGimpyRenderer() {
		this(3);
	}

	public BlockGimpyRenderer(int blockSize) {
		_blockSize = blockSize;
	}

	@Override
	public void gimp(BufferedImage bufferedImage) {
		BlockFilter blockFilter = new BlockFilter();

		blockFilter.setBlockSize(_blockSize);

		applyFilter(bufferedImage, new BufferedImageFilter(blockFilter));
	}

	private final int _blockSize;

}