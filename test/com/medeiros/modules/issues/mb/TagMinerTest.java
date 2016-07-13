package com.medeiros.modules.issues.mb;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.medeiros.modules.issues.service.TagMiner;


public class TagMinerTest {

	TagMiner sut = new TagMiner();
	
	@Test
	public void testExecute_SemTags() {
		String texto = "asdf pouo";
		Map<String, Integer> result = sut.tagsFrom(texto);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isEmpty());
	}
	
	@Test
	public void testExecute_umaTag() {
		String texto = "asdf #tag1 pouo";
		Map<String, Integer> result = sut.tagsFrom(texto);
		Assert.assertNotNull(result);
		Assert.assertEquals("",1, result.size());
		Assert.assertTrue(result.containsKey("tag1"));
	}
	
	@Test
	public void testExecute_variasTags() {
		String texto = "asdf #tag1 pouo #tag2 123#tag1 123";
		Map<String, Integer> result = sut.tagsFrom(texto);
		Assert.assertNotNull(result);
		Assert.assertEquals("",2, result.size());
		Assert.assertEquals("", new Integer(2), result.get("tag1"));
		Assert.assertEquals("", new Integer(1), result.get("tag2"));
	}
	
	@Test
	public void testExecute_SemFeatures() {
		String texto = "asdf pouo";
		Map<String, Integer> result = sut.featuresFrom(texto);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.isEmpty());
	}
	
	@Test
	public void testExecute_umaFeature() {
		String texto = "asdf @tag1 pouo";
		Map<String, Integer> result = sut.featuresFrom(texto);
		Assert.assertNotNull(result);
		Assert.assertEquals("",1, result.size());
		Assert.assertTrue(result.containsKey("tag1"));
	}
	
	@Test
	public void testExecute_variasFeatures() {
		String texto = "asdf @tag1 pouo @tag2 123@tag1 123";
		Map<String, Integer> result = sut.featuresFrom(texto);
		Assert.assertNotNull(result);
		Assert.assertEquals("",2, result.size());
		Assert.assertEquals("", new Integer(2), result.get("tag1"));
		Assert.assertEquals("", new Integer(1), result.get("tag2"));
	}
}
