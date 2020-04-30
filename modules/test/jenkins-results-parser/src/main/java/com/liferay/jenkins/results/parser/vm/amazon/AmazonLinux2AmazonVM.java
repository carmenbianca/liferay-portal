/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.vm.amazon;

/**
 * @author Kiyoshi Lee
 */
public class AmazonLinux2AmazonVM extends AmazonVM {

	protected AmazonLinux2AmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String instanceId) {

		super(awsAccessKeyId, awsSecretAccessKey, instanceId);
	}

	protected AmazonLinux2AmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String instanceType,
		String keyName) {

		super(
			awsAccessKeyId, awsSecretAccessKey, "ami-0782017a917e973e7",
			instanceType, keyName);
	}

	protected AmazonLinux2AmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String imageId,
		String instanceType, String keyName) {

		super(
			awsAccessKeyId, awsSecretAccessKey, imageId, instanceType, keyName);
	}

}