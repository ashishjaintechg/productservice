package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Coupon;
import com.example.demo.models.Product;

@RestController
@RequestMapping("/productapi")
public class ProductController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponService.url}")
	private String couponServiceUrl;

		@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
		public Product getProductDetail(@PathVariable("id") int id) {
			Product p1 =  Product.getProductDetail(id);
			Coupon coupon = restTemplate.getForObject(couponServiceUrl+"SUPER10", Coupon.class);
			p1.setPrice(p1.getPrice() - ((p1.getPrice() * coupon.getDiscount())/100));
			return p1;
		}
		
	}
