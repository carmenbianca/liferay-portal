/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import BackgroundImageProcessor from './BackgroundImageProcessor';
import FallbackProcessor from './FallbackProcessor';
import HTMLProcessor from './HTMLProcessor';
import ImageProcessor from './ImageProcessor';
import LinkProcessor from './LinkProcessor';
import RichTextProcessor from './RichTextProcessor';
import TextProcessor from './TextProcessor';

export default {
	'background-image': BackgroundImageProcessor,
	fallback: FallbackProcessor,
	html: HTMLProcessor,
	image: ImageProcessor,
	link: LinkProcessor,
	'rich-text': RichTextProcessor,
	text: TextProcessor,
};
