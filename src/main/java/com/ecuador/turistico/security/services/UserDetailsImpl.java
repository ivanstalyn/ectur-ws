package com.ecuador.turistico.security.services;

public class UserDetailsImpl  { 

//implements UserDetails  {
	
//	private static final long serialVersionUID = 1L;
//
//	private Long id;
//
//	private String username;
//
//	private String email;
//
//	@JsonIgnore
//	private String password;
//
//	private Collection<? extends GrantedAuthority> authorities;
//	
//
//	
//	
//	public UserDetailsImpl(Long id, String username, String email, String password,
//			Collection<? extends GrantedAuthority> authorities) {
//		this.id = id;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.authorities = authorities;
//	}
//	
//	public static UserDetailsImpl build(User user) {
//		List<GrantedAuthority> authorities = user.getRoles().stream()
//				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
//				.collect(Collectors.toList());
//		
//		//List<List<Perfil>> authorities2 = user.getRoles().stream().map(role-> role.getPerfiles().stream().collect(Collectors.toList())).collect(Collectors.toList());
//
//		//List<MenuT> list = authorities2.stream().flatMap(l-> l.stream().map(a->a.getMenu())).collect(Collectors.toList());
//		
//		//list.forEach(me->me.getIdPadre());
//
//		return new UserDetailsImpl(
//				user.getId(), 
//				user.getUsername(), 
//				user.getEmail(),
//				user.getPassword(), 
//				authorities);
//	}
//
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return username;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//	
//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		UserDetailsImpl user = (UserDetailsImpl) o;
//		return Objects.equals(id, user.id);
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

}
