using ManejoPresupuesto;
using ManejoPresupuesto.Models;
using ManejoPresupuesto.Servicios;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc.Authorization;
using Microsoft.Extensions.DependencyInjection;
using System.Net;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
var politicaUsuariosAutenticados = new AuthorizationPolicyBuilder()
    .RequireAuthenticatedUser()
    .Build();

builder.Services.AddControllersWithViews(opciones =>
{
    opciones.Filters.Add(new AuthorizeFilter(politicaUsuariosAutenticados));
});
builder.Services.AddTransient<IRepositoriosTiposCuentas,RepositoriosTiposCuentas>();
builder.Services.AddTransient<IServicioUsuarios,ServicioUsuarios>();
builder.Services.AddTransient<IRepositorioCuentas,RepositorioCuentas>();
builder.Services.AddTransient<IRepositorioCategorias,RepositorioCategorias>();
builder.Services.AddTransient<IRepositorioTransacciones, RepositorioTransacciones>();
builder.Services.AddTransient<IServicioReportes, ServicioReportes>();
builder.Services.AddAutoMapper(typeof(Program));
builder.Services.AddTransient<IRepositorioUsuarios, RepositorioUsuarios>();
builder.Services.AddHttpContextAccessor();
builder.Services.AddTransient<IUserStore<Usuario>, UsuarioStore>();
builder.Services.AddTransient<SignInManager<Usuario>>();
builder.Services.AddIdentityCore<Usuario>(opciones =>
{
    opciones.Password.RequireDigit = false;
    opciones.Password.RequireLowercase = false;
    opciones.Password.RequireUppercase = false;
    opciones.Password.RequireNonAlphanumeric = false;
    opciones.Password.RequiredUniqueChars = 0;

}).AddErrorDescriber<MensajesDeErrorIdentity>();
builder.Services.AddAuthentication(options =>
{
    options.DefaultAuthenticateScheme = IdentityConstants.ApplicationScheme;
    options.DefaultChallengeScheme = IdentityConstants.ApplicationScheme;
    options.DefaultSignOutScheme = IdentityConstants.ApplicationScheme;
}).AddCookie(IdentityConstants.ApplicationScheme, opciones =>
{
    opciones.LoginPath = "/usuarios/Login";
});


var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthentication(); //agregar este para las cookies del usuario 

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Transacciones}/{action=Index}/{id?}");

app.Run();