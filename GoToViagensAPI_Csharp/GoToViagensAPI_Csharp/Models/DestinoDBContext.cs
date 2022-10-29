using Microsoft.EntityFrameworkCore;
namespace GoToViagensAPI_Csharp.Models
{
    public class DestinoDbContext : DbContext
    {

        public DestinoDbContext(DbContextOptions<DestinoDbContext> options) : base(options)
        { }

        // RELACIONADO À TABELA DO BD
        public DbSet<Destinos> Destinos { get; set; }

    }
}
