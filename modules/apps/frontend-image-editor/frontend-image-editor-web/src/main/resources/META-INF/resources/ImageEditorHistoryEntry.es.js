/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * Image Editor History Entry
 *
 * This class models a step in the image edition process. It stores the
 * Image data at a given point in time so it can be later recovered for
 * undo/redo purposes or other visualization needs.
 * @review
 */
class ImageEditorHistoryEntry {
	/**
	 * Constructor
	 * @review
	 */
	constructor(image) {
		this.dataPromise_ = new Promise(resolve => {
			// Preemtively fetch the imageData when all we have is the image url

			if (image.url && !image.data) {
				this.loadData_(image.url).then(imageData => resolve(imageData));
			}
			else {
				resolve(image.data);
			}
		});
	}

	/**
	 * Fetches an ImageData for a given image url
	 * @param  {String} imageURL The image url to load
	 * @protected
	 * @review
	 */
	loadData_(imageURL) {
		return new Promise(resolve => {
			const bufferImage = new Image();

			bufferImage.onload = () => {
				const bufferCanvas = document.createElement('canvas');
				const bufferContext = bufferCanvas.getContext('2d');

				const height = bufferImage.height;
				const width = bufferImage.width;

				bufferCanvas.width = width;
				bufferCanvas.height = height;

				bufferContext.drawImage(bufferImage, 0, 0, width, height);

				resolve(bufferContext.getImageData(0, 0, width, height));
			};

			bufferImage.src = imageURL;
		});
	}

	/**
	 * Fetches the stored ImageData of this history entry
	 * @return {Promise} A promise that will resolve with the stored ImageData value
	 * @review
	 */
	getImageData() {
		return this.dataPromise_;
	}
}

export default ImageEditorHistoryEntry;
